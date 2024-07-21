import React, { useState } from 'react';
import sumCalculator from './api';

function App() {
  const [result, setResult] = useState(0);

  const handleCalculateSum = async () => {
    const n = 10; // example input
    const response = await sumCalculator(n);
    setResult(response);
  };

  return (
    <div>
      <button onClick={handleCalculateSum}>Calculate Sum</button>
      <p>Result: {result}</p>
    </div>
  );
}

export default App;