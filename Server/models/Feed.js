const Schema = require('mongoose').Schema;
const model = require('mongoose').model;

const feedSchema = Schema({
  message: String,
  date: Date,
  comments: [{
    message: String,
    date: Date,
    sender: {type: Schema.Types.ObjectId, ref: 'User'}
  }],
  starter: {type: Schema.Types.ObjectId, ref: 'User'}
});

const Feed = model('Feed', feedSchema);
module.exports = Feed;