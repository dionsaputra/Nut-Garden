const express = require('express');
const router = express.Router();
const User = require('../models/User');
const constant = require('../config/const');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.put('/:userId/premium', async function(req, res) {
  let userId = req.params.userId;
  let user = await User.findById(userId)
  user.type = constant.user.PREMIUM;
  await user.save();
  res.send({success: true});
});

module.exports = router;
