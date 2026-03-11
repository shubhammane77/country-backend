import React, { useEffect, useState } from "react";
import axios from "axios";
import { 
  Button, 
  List, 
  ListItem, 
  Card, 
  CardContent, 
  Typography, 
  Stack, 
  CircularProgress 
} from "@mui/material";

const App = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedCountry, setSelectedCountry] = useState(null);
  const [cities, setCities] = useState([]);
  const [cityIndex, setCityIndex] = useState(0);
  const [maxCityIndex, setMaxCityIndex] = useState(0);

  // Fetch countries
  useEffect(() => {
    axios.get("http://localhost:8080/countries")
      .then((response) => {
        setData(response.data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  // Fetch cities for selected country and page
  useEffect(() => {
    if (!selectedCountry) return;
    setLoading(true);
    axios.get(`http://localhost:8080/cities/${selectedCountry?.id}?index=${cityIndex}`)
      .then((response) => {
        setCities(response.data);
        setMaxCityIndex(response.data.totalPages - 1);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, [selectedCountry, cityIndex]);

  if (loading) return <Stack alignItems="center" mt={5}><CircularProgress /></Stack>;
  if (error) return <Typography color="error">Error: {error}</Typography>;

  return (
    <Stack direction={{ xs: "column", md: "row" }} spacing={4} p={4}>
      {/* Countries List */}
      <Card sx={{ flex: 1, minWidth: 250 }}>
        <CardContent>
          <Typography variant="h5" gutterBottom>Countries</Typography>
          <List>
            {data.map((country) => (
              <ListItem key={country.id}>
                <Button 
                  variant={selectedCountry?.id === country.id ? "contained" : "outlined"} 
                  fullWidth
                  onClick={() => {
                    setSelectedCountry(country);
                    setCityIndex(0); // reset city page
                  }}
                >
                  {country.name}
                </Button>
              </ListItem>
            ))}
          </List>
        </CardContent>
      </Card>

      {/* Cities List */}
      <Card sx={{ flex: 2, minWidth: 300 }}>
        <CardContent>
          {selectedCountry ? (
            <>
              <Typography variant="h5" gutterBottom>
                Cities in {selectedCountry.name}
              </Typography>
              <List>
                {cities?.content?.map((city) => (
                  <ListItem key={city.id}>
                    <Typography>{city.name}</Typography>
                  </ListItem>
                ))}
              </List>
              <Stack direction="row" spacing={2} mt={2}>
                <Button 
                  variant="contained" 
                  onClick={() => setCityIndex(cityIndex - 1)} 
                  disabled={cityIndex === 0}
                >
                  Previous
                </Button>
                <Button 
                  variant="contained" 
                  onClick={() => setCityIndex(cityIndex + 1)} 
                  disabled={cityIndex === maxCityIndex}
                >
                  Next
                </Button>
              </Stack>
              <Typography mt={1} variant="body2">
                Page {cityIndex + 1} of {maxCityIndex + 1}
              </Typography>
            </>
          ) : (
            <Typography>Select a country to see its cities</Typography>
          )}
        </CardContent>
      </Card>
    </Stack>
  );
};

export default App;