const constant = require('../config/const');
const state = require('../config/state');
const User = require('../models/User');
const Venue = require('../models/Venue');

const measureDistance = function(lat1, lon1, lat2, lon2) {  // generally used geo measurement function
  var R = 6378.137; // Radius of earth in KM
  var dLat = lat2 * Math.PI / 180 - lat1 * Math.PI / 180;
  var dLon = lon2 * Math.PI / 180 - lon1 * Math.PI / 180;
  var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
  Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
  Math.sin(dLon/2) * Math.sin(dLon/2);
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  var d = R * c;
  return d;
};

const getVenues = async (userId) => {
  let user = await User.findById(userId);
    console.log('user:\n' + user);
    let venues = [];
    for (element of user.interests) {
      let venuesFound = await Venue.find({
        type: element
      });
      console.log('venuesFound:\n' + venuesFound);
      let filteredVenues = venuesFound.filter(value => {
        let userLon = user.location.lon;
        let userLat = user.location.lat;
        let venueLon = value.location.lon;
        let venueLat = value.location.lat;
        return measureDistance(userLon, userLat, venueLon, venueLat) <= constant.MIN_DISTANCE;
      });
      console.log('filteredVenues:\n' + filteredVenues);
      venues = venues.concat(filteredVenues);
    }
    return venues;
}

const getRecommendationVenues = async (userId) => {
  let venues = await getVenues(userId);
  let sortedVenuesByRating = venues.sort((a, b) => {
    return b.rating - a.rating;
  }).splice(0, 3);
  let sortedVenuesByCreatedAt = venues.sort((a, b) => {
    return a.createdAt - b.createdAt;
  });
  return sortedVenuesByRating.concat(sortedVenuesByCreatedAt);
}

const getTips = () => {
  return constant.TIPS[Math.floor(Math.random() * constant.TIPS.length)];
}

const updateState = () => {
  // console.log(state.context);
  switch (state.context) {
    case constant.context.GENERAL:
      state.changeContext(constant.context.REMINDER);
      break;
    case constant.context.REMINDER:
      state.changeContext(constant.context.RATE);
      break;
    default:
      state.changeContext(constant.context.GENERAL);
      break;
  }
}

const addRating = async (venueId, score) => {
  let venue = await Venue.findById(venueId);
  venue.rating = (venue.rating*venue.visitors + score) / (venue.visitors + 1);
  venue.visitors++;
  await venue.save();
}

module.exports = {
  getVenues: getVenues,
  getRecommendationVenues: getRecommendationVenues,
  getTips: getTips,
  updateState: updateState,
  addRating: addRating
}