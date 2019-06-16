const express = require('express');
const router = express.Router();
const Feed = require('../models/Feed');
const ObjectId = require('mongoose').mongo.ObjectId;
const User = require('../models/User');

const feedToResponse = async (feed) => {
  let user = await User.findById(feed.starter);
  let comments = [];
  for (comment of feed.comments) {
    let commentUser = await User.findById(comment.sender);
    comments.push({
      message: comment.message,
      date: comment.date,
      sender: {
        name: commentUser.name,
        avatar: commentUser.avatar
      }
    });
  }
  return {
    starter: {
      name: user.name,
      avatar: user.avatar
    },
    message: feed.message,
    date: feed.date,
    comments: comments
  }
}

router.get('/', async function(req, res) {
  let feeds = await Feed.find({});
  let data = []
  for (feed of feeds) {
    data.push(await feedToResponse(feed));
  }
  res.send({success: true, data: data});
});

router.get('/:feedId', async function(req, res) {
  let feed = await Feed.findById(req.params.feedId);
  res.send({success: true, data: await feedToResponse(feed)});
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
  res.send({success: true, data: await feedToResponse(result)});
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
  res.send({success: true, data: await feedToResponse(result)});
});

module.exports = router;