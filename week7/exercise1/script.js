function getRegionForPostcode(postcode, callMeWhenYouGetTheRegion) {
  var url = "https://api.postcodes.io/postcodes/" + postcode;
  $.get(url, function(response) {
    var region = response.result.region;
    callMeWhenYouGetTheRegion(region)
  });
}

function showRegion() {
  var outputElement = document.querySelector("#output");
  var region = getRegionForPostcode("E16LT", function(region) {
    // outputElement.innerText = region;
  });
}

showRegion();
