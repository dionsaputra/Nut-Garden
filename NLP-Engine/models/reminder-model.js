const { NlpManager } = require('node-nlp');

const reminder_model = new NlpManager({ languages: ['id'] });

module.exports = { 
  reminderModel : reminder_model,
  processText : async function(text) {
    response = await reminder_model.process('id', text);

    for(let entityObject in entities ) {
      if (response.entities[entityObject].entity === 'time') {
         return response.entities[entityObject].resolution.values[0].value;
      }
    }

    return 'Maaf, Dichie tidak mengerti maksudnya :('; 
  }
};

