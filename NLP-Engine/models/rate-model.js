const { NlpManager } = require('node-nlp');

const rate_model = new NlpManager({ languages: ['id'] });


module.exports = {
  rateModel : rate_model,
  processText : async function(text) {
    response = await rate_model.process('id', text);
    if (response.entities.length !== 0) {
      entities = response.entities
      for (let entityObject in entities){
        if (response.entities[entityObject].entity === 'number'){
          return response.entities[entityObject].resolution.strValue;
        }
      }
    }
    return 'Maaf, Dichie tidak mengerti maksudnya :(';
  }
};