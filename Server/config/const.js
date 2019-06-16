module.exports = {
  user: {
    PREMIUM: 'premium',
    REGULAR: 'regular' 
  },
  context: {
    GENERAL: 'GENERAL',
    REMINDER: 'REMINDER',
    RATE: 'RATE'
  },
  intent: {
    GENERAL_RECOMMENDATION: 'GENERAL_RECOMMENDATION',
    GENERAL_LIST: 'GENERAL_LIST',
    GENERAL_HEALTH_TIPS: 'GENERAL_HEALTH_TIPS',
    NOT_FOUND: 'NOT_FOUND'
  },
  venue: {
    TENIS: 'tenis',
    RENANG: 'renang',
    FUTSAL: 'futsal',
    VOLI: 'voli',
    BADMINTON: 'badminton',
    SEPAK_BOLA: 'sepak bola'
  },
  MIN_DISTANCE: 10, // in km
  kafka: {
    BUSINESS_MESSAGE: 'business-nlp',
    MESSAGE_BUSINESS: 'nlp-business'
  },
  TIPS: [
    "== TIPS KESEHATAN ==\n\nLakukan aktifitas fisik selama 30 menit setiap harinya\n\nAktifitas fisik yang dimaksud tidak harus dengan berolahraga tetapi dengan berjalan kaki menuju kantor, naik tangga ataupun melakukan aktifitas gerak lainnya yang terpenting bersifat dinamis.",
    "== TIPS KESEHATAN ==\n\nJangan merokok\n\nMerokok dapat menyebabkan kualitas organ-organ penting terganggu seperti paru-paru, otak dan jantung hal ini untuk meminimalisir terganggunya organ vital tersebut maka menghindari rokok menjadi solusi terbaik untuk menjaganya.",
    "== TIPS KESEHATAN ==\n\nKonsumsi makanan sehat\n\nMakanan sehat merupakan faktor penting untuk mensuplai energi dan pembentukan sel-sel serta mebantu kinerja fisiologis agar bejalan dengan baik. Makanan sehat yang harus dikonsumsi seperti mengkonsumsi buah-buahan dan sayuran secukupnya, makanan produk biji-bijian, kurangi mengkonsumsi daging."
  ]
}