const Schema = require('mongoose').Schema;
const model = require('mongoose').model;
const venueSchema = Schema({
    name: String,
    rating: Number,
    visitors: Number,
    picture: String,
    type: String,
    location: {
      address: String,
      lon: Number,
      lat: Number,
    },
    available: Number,
    openHour: String,
    closeHour: String,
    price: Number,
    createdAt: {type: Date, default: Date.now()}
});

const Venue = model('Venue', venueSchema);

module.exports = Venue;