# CloudSync – Android Weather Forecast App

CloudSync is an Android-based weather prediction app that uses ensemble modeling and Open-Meteo's API to deliver reliable short-term forecasts. Built with modern Android architecture and focused on clean UI/UX, CloudSync helps users visualize temperature, wind, and precipitation trends in real time.

## Features

- Location-based weather forecasting  
- Hourly and daily weather updates  
- Real-time temperature, wind speed, and humidity  
- Line charts and icons for intuitive weather visualization  
- Pull-to-refresh sync with Open-Meteo API  
- Responsive UI with support for dark mode

## Tech Stack

- **Language:** Java
- **Architecture:** MVVM  
- **Networking:** Retrofit + Gson  
- **UI:** Material Design, ConstraintLayout  
- **Forecast API:** [Open-Meteo](https://open-meteo.com/)  

## Setup Instructions

1. **Clone this repository:**
   ```bash
   git clone https://github.com/your-username/cloudsync-android.git
   ```
2. Open project on Android Studio
3. Add environment variables(note that these variables are publicly available and Open Meteo does not require an API Key):
   WEATHER_API_BASE_URL=https://api.open-meteo.com/v1/
   LOCATION_API_BASE_URL=https://geocoding-api.open-meteo.com/v1/
   AIRQUALITY_API_BASE_URL=https://air-quality-api.open-meteo.com/v1/air-quality/
   WEATHER_API_TIMEOUT=5000
4. Launch the app.

 -- OR --  
You could just download the [release version](https://github.com/monster-migrate/cloudsync-android/releases/) to test the app without debugging. Remember to enable "Install from Unknown Sources" option in your android device.
