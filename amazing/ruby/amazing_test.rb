require 'amazing'
require 'test/unit'

class TestAmazing < Test::Unit::TestCase

    def testSeed0size15x20
        expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
":--:--:--:--:--:--:--:--:  :--:--:--:--:--:--:\n" +
"I                       I                    I \n" +
":  :--:  :--:--:--:--:  :  :--:--:--:--:--:  :\n" +
"I     I           I     I                 I  I \n" +
":--:  :--:--:--:  :--:--:--:--:--:--:--:  :  :\n" +
"I     I        I     I           I     I  I  I \n" +
":--:  :--:--:  :  :  :  :  :--:--:  :  :  :--:\n" +
"I     I        I  I     I     I     I        I \n" +
":  :--:  :--:--:  :--:  :--:  :  :--:--:--:  :\n" +
"I     I     I  I     I  I     I  I        I  I \n" +
":--:  :--:  :  :--:  :  :--:--:  :--:--:  :  :\n" +
"I  I     I     I     I           I     I  I  I \n" +
":  :  :  :  :  :  :--:--:  :--:--:  :  :  :  :\n" +
"I  I  I     I  I        I     I     I     I  I \n" +
":  :--:--:  :--:  :--:  :  :--:  :--:--:--:  :\n" +
"I           I     I     I  I     I           I \n" +
":--:--:  :--:  :--:  :--:--:  :--:  :--:--:--:\n" +
"I     I  I        I        I     I  I        I \n" +
":  :  :--:  :--:  :--:--:  :--:  :  :  :--:  :\n" +
"I  I        I  I  I     I  I     I  I     I  I \n" +
":  :--:--:--:  :  :  :  :  :  :--:  :--:  :--:\n" +
"I           I  I     I  I  I     I  I  I     I \n" +
":  :--:--:  :  :  :--:--:  :  :  :  :  :--:  :\n" +
"I     I        I  I        I  I  I     I     I \n" +
":--:  :  :--:--:--:  :--:--:  :--:  :--:  :--:\n" +
"I     I     I     I     I  I     I     I     I \n" +
":  :--:--:  :  :  :--:  :  :  :  :--:  :--:  :\n" +
"I  I     I     I     I     I  I  I           I \n" +
":  :  :--:  :--:--:--:--:--:  :--:  :--:--:  :\n" +
"I  I        I        I        I     I     I  I \n" +
":  :--:--:--:  :  :  :  :--:--:  :--:  :  :--:\n" +
"I              I  I  I        I        I     I \n" +
":  :--:--:--:--:--:  :--:--:  :--:  :--:--:  :\n" +
"I     I        I     I     I     I     I     I \n" +
":--:  :  :--:--:  :--:  :--:  :  :--:--:  :--:\n" +
"I              I     I     I  I        I     I \n" +
":--:--:--:--:  :  :  :--:  :  :--:--:  :--:  :\n" +
"I              I  I     I  I        I     I  I \n" +
":  :--:--:--:--:--:--:  :  :--:--:--:  :  :  :\n" +
"I                    I                 I  I  I \n" +
":--:--:--:--:--:--:--:--:--:--:--:--:--:--:  :\n"

        srand 0
        Amazing.doit(15, 20)

        assert_equal expected, $result.to_s
    end

    def testSeed100size4x5
        expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
":--:--:  :--:\n" +
"I           I \n" +
":  :--:--:  :\n" +
"I  I     I  I \n" +
":  :  :  :  :\n" +
"I     I  I  I \n" +
":  :--:  :  :\n" +
"I  I     I  I \n" +
":  :  :--:  :\n" +
"I  I  I     I \n" +
":--:  :--:--:\n"

        srand 100
        Amazing.doit(4, 5)
        assert_equal expected, $result.to_s

    end
end
