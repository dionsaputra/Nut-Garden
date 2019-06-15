const express = require('express');
const router = express.Router();
const Feed = require('../models/Feed');

router.get('/', async function(req, res) {
  let feeds = await Feed.find({});
  res.send({success: true, data: feeds});
});

router.put('/', async function(req, res) {
  
});

module.exports = router;