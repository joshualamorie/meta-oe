DESCRIPTION = "Touchscreen calibration data from xinput-calibrator"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${TOPDIR}/meta-shr/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SECTION = "base"

PR = "r2"
SRC_URI = "file://pointercal.xinput"
S = "${WORKDIR}"

do_install() {
	# Only install file if it has a contents
	if [ -s ${S}/pointercal.xinput ]; then
	        install -d ${D}${sysconfdir}/
	        install -m 0644 ${S}/pointercal.xinput ${D}${sysconfdir}/
	fi
}

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
CONFFILES_${PN} = "${sysconfdir}/pointercal.xinput"