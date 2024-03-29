const { NlpManager } = require('node-nlp');

const GENERAL_LIST = 'GENERAL_LIST';
const GENERAL_RECOMENDATION = 'GENERAL_RECOMMENDATION';
const GENERAL_HEALTH_TIPS = 'GENERAL_HEALTH_TIPS';

const general_model = new NlpManager({ languages: ['id'] });

general_model.addDocument('id', 'daftar lapangan daerah sini dong',GENERAL_LIST)
general_model.addDocument('id', 'ada tempat olahraga apa disekitar sini', GENERAL_LIST);
general_model.addDocument('id', 'daftar tempat olahraga terdekat', GENERAL_LIST);
general_model.addDocument('id', 'cariin lapangan deket sini dong', GENERAL_LIST);
general_model.addDocument('id', 'ada lapangan deket sini ?', GENERAL_LIST);
general_model.addDocument('id', 'daftar tempat olahraga yang dekat', GENERAL_LIST);
general_model.addDocument('id', 'lapangan olahraga ', GENERAL_LIST);

general_model.addDocument('id', 'olahraga yang pas buat aku apa ya?', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'bingung mau olahraga apa', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'pengen olahraga', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'kalau olahraga dimana ya ?', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'butuh rekomendasi olahraga', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'olahraga yang asik apa ya ?', GENERAL_RECOMENDATION);
general_model.addDocument('id', 'rekomendasi', GENERAL_RECOMENDATION);

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

general_model.addAnswer('id', GENERAL_LIST, 'nih list tempat olahraga di sekitar sini');
general_model.addAnswer('id', GENERAL_RECOMENDATION, 'nih daftar tempat olahraga yang menarik di sekitar sini, di liat-liat dulu aja');

general_model.addAnswer('id', GENERAL_HEALTH_TIPS, 'nih ada beberapa cara buat hidup sehat');
general_model.addAnswer('id', GENERAL_HEALTH_TIPS, 'ini list tips untuk hidup sehat!');

(async() => {
    await general_model.train();
})();


module.exports = {
  generalModel : general_model,
  processText : async function(text) {
    response = await general_model.process('id', text);
    if(response.classifications[0].label !== 'None') {
      result = {
        key : response.intent,
        value : response.answer
      }
      return result;
    }
    return {
        key : 'NOT_FOUND',
        value : 'maaf, dichie tidak mengerti maksud kamu. Bisa diulang lagi?'
    };
  }
};