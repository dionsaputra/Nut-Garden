const Schema = require('mongoose').Schema; 
const model = require('mongoose').model;

const userSchema = Schema({
  name: String,
  username: String,
  password: String,
  interests: [String],
  avatar: String,
  type: String,
  location: {
    lon: Number,
    lat: Number,
  },
});

const User = model('User', userSchema);
module.exports = User;