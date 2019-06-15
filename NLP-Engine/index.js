const kafka = require('kafka-node');
const kafkaClient = new kafka.KafkaClient({kafkaHost: '127.0.0.1:9092'});
const consumer =  new kafka.Consumer(kafkaClient, [{topic: 'business-nlp'}]);
const producer = new kafka.Producer(kafkaClient);
const generalModel = require('./models/general-model');
const reminderModel = require('./models/reminder-model');
const rateModel = require('./models/rate-model');

// (async function () {
//   console.log( await generalModel.processText('gmna caranya aku jadi sehat ?'));
//   console.log( await generalModel.processText('aku butuh olahraga nih :\'('));
//   console.log( await generalModel.processText('pengen cari lapangan sekitar sini dong'));
//   console.log( await generalModel.processText('aduh galau :('))

//   // console.log(await reminderModel.processText('ingetin 0 olahraga dong sama jam 19:00'));
//   // console.log(await rateModel.processText('kasih 19:00 nilainya 3 aja deh tempatnya ga gitu bagus'));
//   // console.log(await rateModel.processText('gamau kasih nilai'));
  
// })();


consumer.on('message',async function(message) {
  // let text = JSON.stringify(message)
  request = JSON.parse(message.value);
  try {
    let result = Object;
    if (request.key === 'GENERAL') {
      result = await generalModel.processText(request.value);
    } else if (request.key === 'REMINDER') {
      result = await reminderModel.processText(request.value);      
    } else {
      result = await rateModel.processText(request.value);      
    }

    producer.send([
      {topic: 'nlp-business', messages: JSON.stringify(result)}
    ], () => console.log("Sent result to Dichie Service"));
  
  } catch(err) {
    console.log(err);
  }
});

