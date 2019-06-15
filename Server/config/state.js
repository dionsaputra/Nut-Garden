const constant = require('../config/const');
module.exports = {
  context: constant.context.GENERAL,
  changeContext: function(newContext) {
    this.context = newContext;
  },
  setVenueId: (venueId) => {
    this.venueId = venueId;
  }
}