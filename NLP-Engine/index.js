// const kafka = require('kafka-node');
// const kafkaClient = new kafka.KafkaClient({kafkaHost: '10.232.75.137:9092'});
// const consumer =  new kafka.Consumer(kafkaClient, [{topic: 'business-nlp'}]);
// const producer = new kafka.Producer(kafkaClient);
const generalModel = require('./models/general-model');
const reminderModel = require('./models/reminder-model');
const rateModel = require('./models/rate-model');

(async function () {
  // console.log( await generalModel.processText('why not'));
  // console.log(await reminderModel.processText('ingetin 0 olahraga dong sama jam 19:00'));
  console.log(await rateModel.processText('kasih 19:00 nilainya 3 aja deh tempatnya ga gitu bagus'));
  console.log(await rateModel.processText('gamau kasih nilai'));
  
})();


// (async() => {
//   const response = await generalModel.process('id', 'olahraga apa ya hari ini ?');
//   console.log(computeGeneralModel.halo());
//   console.log(response);  
// })();

// producer.on('ready', function(err) {
//   console.log('asdf');
//   setInterval(() => {
//     producer.send([
//       {topic: 'nlp-business', messages: 'hello'}
//     ], () => console.log("Sent message from producer"));
//   }, 1000);
// });


// consumer.on('message', function(message) {
//   console.log("Received message in consumer : " + JSON.stringify(message));
// });

