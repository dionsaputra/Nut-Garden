const express = require('express');
const router = express.Router();
const Venue = require('../models/Venue');
const User = require('../models/User');
const helper = require('../lib/helper');
const constant = require('../config/const');
const state = require('../config/state');


const getVenues = async userId => {
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
      return helper.measureDistance(userLon, userLat, venueLon, venueLat) <= constant.MIN_DISTANCE;
    });
    console.log('filteredVenues:\n' + filteredVenues);
    venues = venues.concat(filteredVenues);
  }
  return venues;
}

router.get('/:venueId/remind', function(req, res) {
  state.changeContext(constant.context.REMINDER);
  state.setVenueId(req.params.venueId);
  res.send({success: true, data: null});
});

router.get('/', async function(req, res) {
  let userId = req.query.userId;
  let venues = await helper.getVenues(userId);
  console.log("HELPER");
  console.log(console.log(helper));

  let test = {
    a: () => {
      console.log("INSIDE");
      console.log(this);
    }
  }
  console.log("OUTSIDE");
  test.a();
  res.send({success: true, data: venues});
});

router.get('/recommendation', async function(req, res) {
  let userId = req.query.userId;
  let venues = await helper.getRecommendationVenues(userId);
  res.send({success: true, data: venues});
});

module.exports = router;
