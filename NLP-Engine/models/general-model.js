const { NlpManager } = require('node-nlp');

const GENERAL_RECOMENDATION = 'GENERAL_RECOMMENDATION';
const GENERAL_HEALTH_TIPS = 'GENERAL_HEALTH_TIPS';

const general_model = new NlpManager({ languages: ['id'] });
// Adds the utterances and intents for the NLP
general_model.addDocument('id', 'tempat olahraga terdekat', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'ada tempat olahraga apa disekitar sini', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'pengen olahraga', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'cariin lapangan deket sini dong', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'ada lapangan deket sini ?', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'kalau olahraga dimana ya ? ?', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'butuh rekomendasi olahraga', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'lapangan olahraga', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'olahraga asik', GENERAL_RECOMENDATION);

general_model.addDocument('id', 'makanan sehat', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'cara hidup sehat', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'pengen jadi sehat', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'bagaimana cara menjadi sehat ?', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'apakah sehat itu mudah ?', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'rekomendasi hidup sehat', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'cemilan sehat dong', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'tips kesehatan dong', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'cara hidup sehat yang mudah', GENERAL_HEALTH_TIPS);
general_model.addDocument('id', 'pengen kurus', GENERAL_HEALTH_TIPS); 
general_model.addDocument('id', 'pengen sixpack', GENERAL_HEALTH_TIPS); 

// Train also the NLG
general_model.addAnswer('id', GENERAL_RECOMENDATION, 'nih list tempat olahraga di sekitar sini');
general_model.addAnswer('id', GENERAL_RECOMENDATION, 'nih daftar olahraga sekitar sini, di liat-liat dulu aja');

general_model.addAnswer('id', GENERAL_HEALTH_TIPS, 'nih ada beberapa cara buat hidup sehat');
general_model.addAnswer('id', GENERAL_HEALTH_TIPS, 'ini list tips untuk hidup sehat!');

// Train and save the model.
(async() => {
    await general_model.train();
    // general_model.save('GENERAL_MODEL.nlp');
    const response = await general_model.process('id', 'tempat olahraga dareah sini ada apa aja ?');
    const response2 = await general_model.process('id', 'duh gimana yaa bisa jadi lebih sehat');
    console.log(response2.answer);
    console.log(response.answer);
})();