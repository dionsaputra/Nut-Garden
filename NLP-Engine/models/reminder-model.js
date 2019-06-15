const { NlpManager } = require('node-nlp');

const reminder_model = new NlpManager({ languages: ['id'] });

module.exports = { 
  reminderModel : reminder_model,
  processText : async function(text) {
    response = await reminder_model.process('id', text);
    for(let entityObject in response.entities ) {
      if (response.entities[entityObject].entity === 'time') {
        console.log(response.entities[entityObject].resolution.values[0].value);
        return {
          success: true,
          value : response.entities[entityObject].resolution.values[0].value
        }
      }
    }
    return {
      success : false,
      value : 'Maaf, Dichie tidak mengerti maksudnya :(' 
    }
  }
};

