import { Schema, model, Mongoose } from 'mongoose';

const feedSchema = Schema({
  message: String,
  date: Date,
  comments: [{
    message: String,
    date: Date,
    sender: {type: Mongoose.Schema.Types.ObjectId, ref: 'User'}
  }]
});

const Feed = model('Feed', feedSchema);