const constant = require('../config/const');
module.exports = {
  context: constant.context.GENERAL,
  venueId: null,
  changeContext: function(newContext) {
    this.context = newContext;
  },
  setVenueId: function(venueId) {
    this.venueId = venueId;
  }
}