class Machine
  attr_reader :name, :bin, :location

  def initialize(name, location)
    @name = name
    @location = location
  end

  def take
    result = @bin
    @bin = nil
    return result
  end	

  def put(bin)
    @bin = bin
  end
end
