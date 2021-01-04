async function getData(selectedPath) {
  const proxy = "http://localhost:8080/FashionProject/api";
  const urlPath = selectedPath;
  try {
    const response = await fetch(`${proxy}${urlPath}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });
    if (response.ok) {
      const jsonResponse = await response.json();
      console.log(jsonResponse);
    }
  } catch (error) {
    console.log(error);
  }
}


export { getData };