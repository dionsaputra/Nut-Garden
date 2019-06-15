const express = require('express');
const router = express.Router();
const helper = require('../lib/helper');
const constant = require('../config/const');
const state = require('../config/state');
const kafka = require('../lib/kafka');

router.post('/', async function(req, res) {
  let message = req.body.message;
  let userId = req.query.userId;
  let km1 = new kafka.KeyedMessage('CONTEXT', state.context);
  let km2 = new kafka.KeyedMessage('MESSAGE', message);
  kafka.producer.send([{
    topic: constant.kafka.BUSINESS_MESSAGE,
    messages: [km1, km2]
  }], function(err, data) {
    console.log(err);
    console.log(data);
  });
  kafka.consumer.on('message', function(message) {
    console.log("TESTTT" + message);
    kafka.consumer.close(true, function(error) {
      console.log(error);
    });
    kafka.reloadConsumer();
    res.send(message);
    return;
  });
});

router.get('/tips', function(req, res) {
  res.send({success: true, data: {message: helper.getTips()}});
});

module.exports = router;