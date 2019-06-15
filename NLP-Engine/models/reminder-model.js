const { NlpManager } = require('node-nlp');

const reminder_model = new NlpManager({ languages: ['id'] });

// Train and save the model.
(async() => {
    const response3 = await reminder_model.process('id', 'ingatkan aku besok olahraga jam 19:00');
    console.log(response3);
})();