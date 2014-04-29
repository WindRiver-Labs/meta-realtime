DESCRIPTION = "rt-app is a test application that starts multiple periodic threads in order to simulate a real-time periodic load"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.in;endline=339;md5=e43fc16fccd8519fba405f0a0ff6e8a3"

SRCREV = "17be4548c4260b80be623e0e1317e98a770dea7a"

SRC_URI = "git://github.com/gbagnoli/rt-app.git \
	file://0001-set-with-deadline-as-a-default-to-go-around-yocto-bu.patch \
	"

S = "${WORKDIR}/git"

inherit autotools gettext pkgconfig

do_install() {
     	install -d ${D}${bindir}
     	install -m 0755 src/rt-app ${D}${bindir}
}

FILES_{PN} = "${bindir}/rt-app" 

PARALLEL_MAKE = ""
