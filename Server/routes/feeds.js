const express = require('express');
const router = express.Router();
const Feed = require('../models/Feed');
const ObjectId = require('mongoose').mongo.ObjectId;

router.get('/', async function(req, res) {
  let feeds = await Feed.find({});
  res.send({success: true, data: feeds});
});

router.post('/', async function(req, res) {
  let message = req.body.message;
  let starter = req.body.userId;

  let result = await Feed.create({
    message: message,
    date: Date.now(),
    comments: [],
    starter: new ObjectId(starter)
  })
  res.send({success: true, data: result});
});

router.put('/:feedId', async function(req, res) {
  let message = req.body.message;
  let sender = req.body.userId;

  let result = await Feed.findById(req.params.feedId);
  result.comments.push({
    message: message,
    date: Date.now(),
    sender: new ObjectId(sender)
  });
  result = await result.save();
  res.send({success: true, data: result});
});

module.exports = router;