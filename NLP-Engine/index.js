const kafka = require('kafka-node');
const kafkaClient = new kafka.KafkaClient({kafkaHost: '127.0.0.1:9092'});
const consumer =  new kafka.Consumer(kafkaClient, [{topic: 'business-nlp'}]);
const producer = new kafka.Producer(kafkaClient);
const generalModel = require('./models/general-model');
const reminderModel = require('./models/reminder-model');
const rateModel = require('./models/rate-model');



consumer.on('message',async function(message) {
  let request = JSON.parse(message.value);
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

