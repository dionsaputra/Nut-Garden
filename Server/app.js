var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const mongoose = require('mongoose');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var venueRouter = require('./routes/venues');

var app = express();

mongoose.connect('mongodb://localhost:27017/dichie');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/venues', venueRouter);


app.listen(3000, () => {
  console.log('Running on port 3000');
});

module.exports = app;
