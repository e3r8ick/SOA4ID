export default {
  Query: {
    allNews: async (parent, args, { News }) => {
      const news = await News.find();
      return news.map(x => {
        x._id = x._id.toString();
        return x;
      })
    }
  },
  Mutation: {
    createNews: async (parent, args, { News }) => {
      const news = await new News(args).save();
      news._id = news._id.toString();
      news.type = "1";
      return news;
    }
  },
  Mutation: {
    getNews: async (parent, args, { News }) => {
      console.log(args);
      const news = await News.find(args);
      return news;
    }
  },
  Mutation: {
    updateNews: async (parent, args, { News }) => {
      console.log(args);
      const news = await News.find(args);
      news._id = news._id.toString();
      news.title = args.title;
      news.subtitle = args.subtitle;
      news.sport = args.sport;
      return news;
    }
  }
}
