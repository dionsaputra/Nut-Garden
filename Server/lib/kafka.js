const kafka = require('kafka-node');
const constant = require('../config/const');

const KeyedMessage = kafka.KeyedMessage;

var kafkaClient = new kafka.KafkaClient({kafkaHost: '127.0.0.1:9092'});
var consumer =  new kafka.Consumer(kafkaClient, [{topic: constant.kafka.MESSAGE_BUSINESS}]);
var producer =  new kafka.Producer(kafkaClient);


module.exports = {
  consumer: consumer,
  reloadConsumer: function() {
    kafkaClient = new kafka.KafkaClient({kafkaHost: '127.0.0.1:9092'});
    this.producer = new kafka.Producer(kafkaClient);
    this.consumer = new kafka.Consumer(kafkaClient, [{topic: constant.kafka.MESSAGE_BUSINESS}]);
  },
  producer: producer,
  KeyedMessage: KeyedMessage
}