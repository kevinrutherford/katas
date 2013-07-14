#! C:/ruby/bin/ruby -w
#
# + The original program is by Jack Hauber, and the source is
#   "Basic Computer Games." Used with permission of David Ahl;
#   see www.SwapMeetDave.com.
# + This exercise was inspired by Alan Hensel's use of Amazing
#   as a refactoring challenge.
# + This transliteration to Ruby was created by Kevin Rutherford,
#   kevin@rutherford-software.co.uk
#

class Amazing
    $target = 0                         # where GOTO goes
    $result = ''

    def Amazing.clear
        $result = ''
    end

    def Amazing.println
        $result = $result + "\n"
    end

    def Amazing.print(text)
        $result = $result + text
    end

    def Amazing.rnd(count)
        (count * rand).to_i + 1
    end

    def Amazing.goto(lineno)
        $target = lineno
    end

    def Amazing.doit(horizontal, vertical)
        Amazing.clear
        Amazing.print("Amazing - Copyright by Creative Computing, Morristown, NJ")
        Amazing.println

        h = horizontal
        v = vertical
        return if (h == 1 || v == 1)

        wArray = Array.new(h+1) { Array.new(v+1, 0) }
        vArray = Array.new(h+1) { Array.new(v+1, 0) }

        q = 0
        z = 0
        x = Amazing.rnd(h)

        # 130:170
        (1..h).each { |i|
            if i == x
                Amazing.print(":  ")
            else
                Amazing.print(":--")
            end
        }
        # 180
        Amazing.print(":")
        Amazing.println

        # 190
        c = 1
        wArray[x][1] = c
        c = c+1

        # 200
        r = x
        s = 1
        Amazing.goto(270)

        while $target != -1
            case $target
                when 210
                    if r != h
                        Amazing.goto(250)
                    else
                        Amazing.goto(220)
                    end
                when 220
                    if s != v
                        Amazing.goto(240)
                    else
                        Amazing.goto(230)
                    end
                when 230
                    r = 1
                    s = 1
                    Amazing.goto(260)
                when 240
                    r = 1
                    s = s+1
                    Amazing.goto(260)
                when 250
                    r = r+1
                    Amazing.goto(260)
                when 260
                    if wArray[r][s] == 0
                        Amazing.goto(210)
                    else
                        Amazing.goto(270)
                    end
                when 270
                    if r - 1 == 0
                        Amazing.goto(600)
                    else
                        Amazing.goto(280)
                    end
                when 280
                    if wArray[r - 1][s] != 0
                        Amazing.goto(600)
                    else
                        Amazing.goto(290)
                    end
                when 290
                    if s - 1 == 0
                        Amazing.goto(430)
                    else
                        Amazing.goto(300)
                    end
                when 300
                    if wArray[r][s - 1] != 0
                        Amazing.goto(430)
                    else
                        Amazing.goto(310)
                    end
                when 310
                    if r == h
                        Amazing.goto(350)
                    else
                        Amazing.goto(320)
                    end
                when 320
                    if wArray[r + 1][s] != 0
                        Amazing.goto(350)
                    else
                        Amazing.goto(330)
                    end
                when 330
                    x = Amazing.rnd(3)
                    Amazing.goto(340)
                when 340
                    if x == 1
                        Amazing.goto(940)
                    elsif x == 2
                        Amazing.goto(980)
                    elsif x == 3
                        Amazing.goto(1020)
                    else
                        Amazing.goto(350)
                    end
                when 350
                    if s != v
                        Amazing.goto(380)
                    else
                        Amazing.goto(360)
                    end
                when 360
                    if z == 1
                        Amazing.goto(410)
                    else
                        Amazing.goto(370)
                    end
                when 370
                    q = 1
                    Amazing.goto(390)
                when 380
                    if wArray[r][s + 1] != 0
                        Amazing.goto(410)
                    else
                        Amazing.goto(390)
                    end
                when 390
                    x = Amazing.rnd(3)
                    Amazing.goto(400)
                when 400
                    if x == 1
                        Amazing.goto(940)
                    elsif x == 2
                        Amazing.goto(980)
                    elsif x == 3
                        Amazing.goto(1090)
                    else
                        Amazing.goto(410)
                    end
                when 410
                    x = Amazing.rnd(2)
                    Amazing.goto(420)
                when 420
                    if x == 1
                        Amazing.goto(940)
                    elsif x == 2
                        Amazing.goto(980)
                    else
                        Amazing.goto(430)
                    end
                when 430
                    if r == h
                        Amazing.goto(530)
                    else
                        Amazing.goto(440)
                    end
                when 440
                    if wArray[r + 1][s] != 0
                        Amazing.goto(530)
                    else
                        Amazing.goto(450)
                    end
                when 450
                    if s != v
                        Amazing.goto(480)
                    else
                        Amazing.goto(460)
                    end
                when 460
                    if z == 1
                        Amazing.goto(510)
                    else
                        Amazing.goto(470)
                    end
                when 470
                    q = 1
                    Amazing.goto(490)
                when 480
                    if wArray[r][s + 1] != 0
                        Amazing.goto(510)
                    else
                        Amazing.goto(490)
                    end
                when 490
                    x = Amazing.rnd(3)
                    Amazing.goto(500)
                when 500
                    if x == 1
                        Amazing.goto(940)
                    elsif x == 2
                        Amazing.goto(1020)
                    elsif x == 3
                        Amazing.goto(1090)
                    else
                        Amazing.goto(510)
                    end
                when 510
                    x = Amazing.rnd(2)
                    Amazing.goto(520)
                when 520
                    if x == 1
                        Amazing.goto(940)
                    elsif x == 2
                        Amazing.goto(1020)
                    else
                        Amazing.goto(530)
                    end
                when 530
                    if s != v
                        Amazing.goto(560)
                    else
                        Amazing.goto(540)
                    end
                when 540
                    if z == 1
                        Amazing.goto(590)
                    else
                        Amazing.goto(550)
                    end
                when 550
                    q = 1
                    Amazing.goto(570)
                when 560
                    if wArray[r][s + 1] != 0
                        Amazing.goto(590)
                    else
                        Amazing.goto(570)
                    end
                when 570
                    x = Amazing.rnd(2)
                    Amazing.goto(580)
                when 580
                    if x == 1
                        Amazing.goto(940)
                    elsif x == 2
                        Amazing.goto(1090)
                    else
                        Amazing.goto(590)
                    end
                when 590
                    Amazing.goto(940)
                when 600
                    if s - 1 == 0
                        Amazing.goto(790)
                    else
                        Amazing.goto(610)
                    end
                when 610
                    if wArray[r][s - 1] != 0
                        Amazing.goto(790)
                    else
                        Amazing.goto(620)
                    end
                when 620
                    if r == h
                        Amazing.goto(720)
                    else
                        Amazing.goto(630)
                    end
                when 630
                    if wArray[r + 1][s] != 0
                        Amazing.goto(720)
                    else
                        Amazing.goto(640)
                    end
                when 640
                    if s != v
                        Amazing.goto(670)
                    else
                        Amazing.goto(650)
                    end
                when 650
                    if z == 1
                        Amazing.goto(700)
                    else
                        Amazing.goto(660)
                    end
                when 660
                    q = 1
                    Amazing.goto(680)
                when 670
                    if wArray[r][s + 1] != 0
                        Amazing.goto(700)
                    else
                        Amazing.goto(680)
                    end
                when 680
                    x = Amazing.rnd(3)
                    Amazing.goto(690)
                when 690
                    if x == 1
                        Amazing.goto(980)
                    elsif x == 2
                        Amazing.goto(1020)
                    elsif x == 3
                        Amazing.goto(1090)
                    else
                        Amazing.goto(700)
                    end
                when 700
                    x = Amazing.rnd(2)
                    Amazing.goto(710)
                when 710
                    if x == 1
                        Amazing.goto(980)
                    elsif x == 2
                        Amazing.goto(1020)
                    else
                        Amazing.goto(720)
                    end
                when 720
                    if s != v
                        Amazing.goto(750)
                    else
                        Amazing.goto(730)
                    end
                when 730
                    if z == 1
                        Amazing.goto(780)
                    else
                        Amazing.goto(740)
                    end
                when 740
                    q = 1
                    Amazing.goto(760)
                when 750
                    if wArray[r][s + 1] != 0
                        Amazing.goto(780)
                    else
                        Amazing.goto(760)
                    end
                when 760
                    x = Amazing.rnd(2)
                    Amazing.goto(770)
                when 770
                    if x == 1
                        Amazing.goto(980)
                    elsif x == 2
                        Amazing.goto(1090)
                    else
                        Amazing.goto(780)
                    end
                when 780
                    Amazing.goto(980)
                when 790
                    if r == h
                        Amazing.goto(880)
                    else
                        Amazing.goto(800)
                    end
                when 800
                    if wArray[r + 1][s] != 0
                        Amazing.goto(880)
                    else
                        Amazing.goto(810)
                    end
                when 810
                    if s != v
                        Amazing.goto(840)
                    else
                        Amazing.goto(820)
                    end
                when 820
                    if z == 1
                        Amazing.goto(870)
                    else
                        Amazing.goto(830)
                    end
                when 830
                    q = 1
                    Amazing.goto(990)
                when 840
                    if wArray[r][s + 1] != 0
                        Amazing.goto(870)
                    else
                        Amazing.goto(850)
                    end
                when 850
                    x = Amazing.rnd(2)
                    Amazing.goto(860)
                when 860
                    if x == 1
                        Amazing.goto(1020)
                    elsif x == 2
                        Amazing.goto(1090)
                    else
                        Amazing.goto(870)
                    end
                when 870
                    Amazing.goto(1020)
                when 880
                    if s != v
                        Amazing.goto(910)
                    else
                        Amazing.goto(890)
                    end
                when 890
                    if z == 1
                        Amazing.goto(930)
                    else
                        Amazing.goto(900)
                    end
                when 900
                    q = 1
                    Amazing.goto(920)
                when 910
                    if wArray[r][s + 1] != 0
                        Amazing.goto(930)
                    else
                        Amazing.goto(920)
                    end
                when 920
                    Amazing.goto(1090)
                when 930
                    Amazing.goto(1190)
                when 940
                    wArray[r - 1][s] = c
                    Amazing.goto(950)
                when 950
                    c = c+1
                    vArray[r - 1][s] = 2
                    r = r-1
                    Amazing.goto(960)
                when 960
                    if c == h * v + 1
                        Amazing.goto(1200)
                    else
                        Amazing.goto(970)
                    end
                when 970
                    q = 0
                    Amazing.goto(270)
                when 980
                    wArray[r][s - 1] = c
                    Amazing.goto(990)
                when 990
                    c = c+1
                    Amazing.goto(1000)
                when 1000
                    vArray[r][s - 1] = 1
                    s = s-1
                    if c == h * v + 1
                        Amazing.goto(1200)
                    else
                        Amazing.goto(1010)
                    end
                when 1010
                    q = 0
                    Amazing.goto(270)
                when 1020
                    wArray[r + 1][s] = c
                    Amazing.goto(1030)
                when 1030
                    c = c+1
                    if vArray[r][s] == 0
                        Amazing.goto(1050)
                    else
                        Amazing.goto(1040)
                    end
                when 1040
                    vArray[r][s] = 3
                    Amazing.goto(1060)
                when 1050
                    vArray[r][s] = 2
                    Amazing.goto(1060)
                when 1060
                    r = r+1
                    Amazing.goto(1070)
                when 1070
                    if c == h * v + 1
                        Amazing.goto(1200)
                    else
                        Amazing.goto(1080)
                    end
                when 1080
                    Amazing.goto(600)
                when 1090
                    if q == 1
                        Amazing.goto(1150)
                    else
                        Amazing.goto(1100)
                    end
                when 1100
                    wArray[r][s + 1] = c
                    c = c+1
                    if vArray[r][s] == 0
                        Amazing.goto(1120)
                    else
                        Amazing.goto(1110)
                    end
                when 1110
                    vArray[r][s] = 3
                    Amazing.goto(1130)
                when 1120
                    vArray[r][s] = 1
                    Amazing.goto(1130)
                when 1130
                    s = s+1
                    if c == v * h + 1
                        Amazing.goto(1200)
                    else
                        Amazing.goto(1140)
                    end
                when 1140
                    Amazing.goto(270)
                when 1150
                    z = 1
                    Amazing.goto(1160)
                when 1160
                    if vArray[r][s] == 0
                        Amazing.goto(1180)
                    else
                        Amazing.goto(1170)
                    end
                when 1170
                    vArray[r][s] = 3
                    q = 0
                    Amazing.goto(1190)
                when 1180
                    vArray[r][s] = 1
                    q = 0
                    r = 1
                    s = 1
                    Amazing.goto(260)
                when 1190
                    Amazing.goto(210)
                when 1200
                    $target = -1
            end

        end

        # 1200
        (1..v).each { |j|
            Amazing.print("I")        # 1210

            (1..h).each { |i|
                if vArray[i][j] >= 2
                    Amazing.print("   ")  # 1240
                else
                    Amazing.print("  I")  # 1260
                end
            }

            Amazing.print(" ")   # 1280
            Amazing.println

            (1..h).each { |i|
                if vArray[i][j] == 0
                    Amazing.print(":--")   # 1300, 1340
                elsif vArray[i][j] == 2
                    Amazing.print(":--")  # 1310, 1340
                else
                    Amazing.print(":  ") # 1320
                end
            }

            Amazing.print(":")    # 1360
            Amazing.println
        }
    end
end
