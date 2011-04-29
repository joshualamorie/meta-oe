DESCRIPTION = "Proxy libintl"
HOMEPAGE = "http://ftp.gnome.org/pub/GNOME/binaries/win32/dependencies/"
SECTION = "libs"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://src/proxy-libintl/COPYING.LIB.txt;md5=bc400bc21422f9a92e76ec2c5167ca2e"

PR = "r0"
PROVIDES = "virtual/libintl virtual/gettext"

SRC_URI = " \
    http://ftp.gnome.org/pub/GNOME/binaries/win32/dependencies/${PN}-dev_${PV}_win32.zip \
"
SRC_URI[md5sum] = "aef407c2b97ee829383aadd867c61d1e"
SRC_URI[sha256sum] = "291ac350cc5eb4a01b0d651ca99fae64cee8a1c06b2005277fab5a4356f9ae91"

S = "${WORKDIR}"
FILES_${PN}-dev = "${includedir}/libintl.h ${libdir}/libintl.a"

CFLAGS_append = " -Wall -I ../../include ${@['-DSTUB_ONLY', ''][bb.data.getVar('USE_NLS', d, 1) != 'no']}"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
    cd ${WORKDIR}/src/proxy-libintl
    oe_runmake ../../lib/libintl.a
}

do_install() {
    install -d ${D}/${includedir}
    install -d ${D}/${libdir}
    install -m 0644 ${WORKDIR}/include/libintl.h ${D}/${includedir}
    install -m 0644 ${WORKDIR}/lib/libintl.a ${D}/${libdir}
}