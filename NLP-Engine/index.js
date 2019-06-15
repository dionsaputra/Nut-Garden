const kafka = require('kafka-node');
const kafkaClient = new kafka.KafkaClient({kafkaHost: '10.232.75.137:9092'});
const consumer =  new kafka.Consumer(kafkaClient, [{topic: 'business-nlp'}]);
const producer = new kafka.Producer(kafkaClient);

producer.on('ready', function(err) {
  console.log('asdf');
  setInterval(() => {
    producer.send([
      {topic: 'nlp-business', messages: 'hello'}
    ], () => console.log("Sent message from producer"));
  }, 1000);
});


consumer.on('message', function(message) {
  console.log("Received message in consumer : " + JSON.stringify(message));
});

