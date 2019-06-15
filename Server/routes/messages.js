const express = require('express');
const router = express.Router();
const helper = require('../lib/helper');
const constant = require('../config/const');
const state = require('../config/state');
const kafka = require('../lib/kafka');


router.post('/', async function(req, res) {
  let message = req.body.message;
  // let userId = req.query.userId;
  kafka.producer.send([{
    topic: constant.kafka.BUSINESS_MESSAGE,
    messages: JSON.stringify({key: state.context, value: message})
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