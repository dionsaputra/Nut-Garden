import { Schema, model } from 'mongoose';

const userSchema = Schema({
  name: String,
  username: String,
  password: String,
  interests: [String],
  avatar: String
});

const User = model('User', userSchema);

export default User;