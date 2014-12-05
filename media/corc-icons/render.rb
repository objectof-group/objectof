#!/usr/bin/ruby

def render(svgs, size)
	`mkdir ./#{size}`
	svgs.each{|svg| `rsvg -h #{size} -w #{size} #{svg} ./#{size}/#{svg[0..-5]}-#{size}.png`}
end

svgs = `ls *.svg`.strip.split("\n")

render(svgs, 16)
render(svgs, 22)
render(svgs, 24)
render(svgs, 32)
render(svgs, 48)
render(svgs, 64)
render(svgs, 72)
render(svgs, 96)
render(svgs, 128)
render(svgs, 256)

