import React, { useEffect, useState } from "react";
import axios from "axios";
import { Button } from "@mui/material";

const App = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedCountry, setSelectedCountry] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8080/countries")
      .then((response) => {
        setData(response.data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div className="row" style={{ display: "flex", gap: "20px" }}>
      <div className="column" style={{ flex: 1 }}>
        <h1>Countries</h1>
        <ul>
          {data.map((country) => (
            <li key={country.id}>
              <Button
                onClick={() => setSelectedCountry(country)}
              >
                {country.name}
              </Button>
            </li>
          ))}
        </ul>
      </div>
      <div className="column" style={{ flex: 1 }}>
        {selectedCountry ? (
          <div>
            <h2>Cities in {selectedCountry.name}</h2>
            <ul>
              {selectedCountry.cityList.map((city) => (
                <li key={city.id}>
                  <p1 variant="outlined">{city.name}</p1>
                </li>
              ))}
            </ul>
          </div>
        ) : (
          <div>Select a country to see its cities</div>
        )}
      </div>
    </div>
  );
};

export default App;