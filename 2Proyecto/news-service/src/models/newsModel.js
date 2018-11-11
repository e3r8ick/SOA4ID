import mongoose from 'mongoose';
const Schema = mongoose.Schema;

const newsSchema = new Schema({
  type: String,
  title: String,
  subtitle: String,
  sport: String
});

const news = mongoose.model('news', newsSchema);

export default news;
