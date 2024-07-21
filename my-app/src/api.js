import axios from 'axios';

const API_URL = 'http://localhost:3000/sum';

const sumCalculator = async (n) => {
  const response = await axios.post(API_URL, { n });
  return response.data;
};

export default sumCalculator;