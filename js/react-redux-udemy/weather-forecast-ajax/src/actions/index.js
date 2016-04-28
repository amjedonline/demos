import axios from 'axios';

const API_KEY = '145af9d173b0c6c194cceb2c609f5708';
// ES6 template strings

const ROOT_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;


export const FETCH_WEATHER = 'FETCH_WEATHER';

// this is an Actions creator
export function fetchWeather(city) {
 const url = `${ROOT_URL}&q=${city},us`

 // returns a promise
 const request = axios.get(url);

 console.log('Request: ', request);

 return {
   type: FETCH_WEATHER,
   payload: request
 }
}
