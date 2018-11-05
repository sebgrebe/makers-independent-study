describe("Script", function() {

  var region;

  describe("getRegionForPostcode",function(){
    beforeEach(function(done) {
      setTimeout(function() {
        done();
      }, 1000);
    });

    it("should get region London for post code E16LT",function(done){
      getRegionForPostcode("E16LT",function(region) {
        expect(region).toEqual('London')
        done()
      })
    })
    it("should not get region Edinburgh for post code E16LT",function(done){
      getRegionForPostcode("E16LT",function(region) {
        expect(region).not.toEqual('Edinburgh')
        done()
      })
    })
  })
});
