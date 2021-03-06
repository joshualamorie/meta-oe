DESCRIPTION = "EFL based thumbnail generation library"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a6db9e80255adbafa16e817d9a4d8c"
DEPENDS = "libexif eet-native evas ecore edje eet edbus emotion epdf"
PV = "0.1.0+svnr${SRCPV}"
PR = "r3"
SRCREV = "${EFL_SRCREV}"

inherit efl
SRC_URI = "${E_SVN}/trunk;module=${SRCNAME};proto=http;scmdata=keep"
S = "${WORKDIR}/${SRCNAME}"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
  --disable-docs \
"

# Some upgrade path tweaking, as in evas
AUTO_LIBNAME_PKGS = ""

FILES_${PN} += "\
    ${bindir}/ethumbd \
    ${libexecdir}/ethumbd_slave \
"
