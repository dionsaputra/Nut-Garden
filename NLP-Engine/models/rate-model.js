const { NlpManager } = require('node-nlp');

const rate_model = new NlpManager({ languages: ['id'] });

// Train and save the model.
// (async() => {
//   const response = await rate_model.process('id', 'tempatnya kurang bagus kasih nilai 3.5 aja');

//   console.log(response.entities[0].resolution);  
// })();

module.exports = rate_model;