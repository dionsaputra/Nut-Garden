const express = require('express');
const router = express.Router();
const helper = require('../lib/helper');
const constant = require('../config/const');
const state = require('../config/state');
const kafka = require('../lib/kafka');

const processMessage = async (intent, reply, userId) => {
  switch (intent) {
    case constant.intent.GENERAL_LIST:
      return {
        message: reply,
        venues: await helper.getVenues(userId)
      };
      break;
    case constant.intent.GENERAL_RECOMMENDATION:
      return {
        message: reply,
        venues: await helper.getRecommendationVenues(userId)
      };
      break;
    case constant.intent.GENERAL_HEALTH_TIPS:
      return {
        message: helper.getTips(),
        venues: null
      };
      break;
    default:
      return {
        message: reply,
        venues: null
      }
      break;
  }
}

router.post('/', async function(req, res) {
  let message = req.body.message;
  let userId = req.body.userId;
  kafka.producer.send([{
    topic: constant.kafka.BUSINESS_MESSAGE,
    messages: JSON.stringify({key: state.context, value: message})
  }], function(err, data) {
    console.log(err);
    console.log(data);
  });
  kafka.consumer.on('message', async function(message) {
    console.log("TESTTT" + message);
    kafka.consumer.close(true, function(error) {
      console.log(error);
    });
    kafka.reloadConsumer();
    console.log(message);
    let messageObject = JSON.parse(message.value);
    console.log('context ' + state.context);
    if (state.context == constant.context.GENERAL) {
      let data = await processMessage(messageObject.key, messageObject.value, userId);
      console.log('context ' + state.context);
      res.send({success: true, data: data});
    } else {
      console.log(messageObject);
      if (!messageObject.success) {
        res.send({success: false, data: {
          message: messageObject.value,
          venues: null
        }});
      } 
      else {
        if (state.context == constant.context.RATE) {
          await helper.addRating(state.venueId, parseInt(messageObject.value));
          res.send({success: true, data: {message: "Makasih feedback nya ya, ada lagi yang bisa Dichie bantu ?", venues: null}});
        } else {
          res.send({success: true, data: {message: "Siap, nanti Dichi ingatkan ya.", venues: null}})
        }
        helper.updateState();
      }
    }
  });
});

router.get('/tips', function(req, res) {
  res.send({success: true, data: {message: helper.getTips()}});
});

module.exports = router;