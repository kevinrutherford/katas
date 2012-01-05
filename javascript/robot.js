function Robot() {
	this.location = null;
	this.bin = null;
}

Robot.prototype = {
  move_to: function(location){
    this.location = location;
  },

  pick: function() {
    this.bin = this.location.take();
  },

  release: function() {
    this.location.put(this.bin);
    this.bin = null;
  },

  toString: function() {
  	return '[object Robot]';
  }
}