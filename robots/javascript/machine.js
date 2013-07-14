function Machine(name, location) {
	this.name = name;
	this.bin = null;
	this.location = location;
}

Machine.prototype = {
  take: function() {
    var result = this.bin
    this.bin = null;
    return result;
  },

  put: function(bin) {
    this.bin = bin;
  },

  toString: function() {
  	return '[object Machine]';
  }
}
