import { Schema, model } from 'mongoose';

const venueSchema = Schema({
    name: String,
    rating: Number,
    picture: String,
    type: String,
    location: {
      address: String,
      lon: Number,
      lat: Number,
    },
    available: Number,
    openHour: Date,
    closeHour: Date,
    price: Number
});

const Venue = model('Venue', venueSchema);

export default Venue;