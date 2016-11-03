SUMMARY = "OpenYard Minimial Image"
DESCRIPTION = "Image for OpenYard development"
LICENSE = "MIT"

include rpi-basic-image.bb

# IMAGE_FEATURES += " nodejs"

IMAGE_ROOTFS_SIZE ?= "8192"

DISTRO_FEATURES += " \
"

IMAGE_INSTALL = " \
  gcc-4.8-multilib \
  g++-4.8-multilib \
  nodejs \
"

# this is a pure qt5 embedded demo image without X
# CONFLICT_DISTRO_FEATURES = "x11 wayland"
# REQUIRED_DISTRO_FEATURES = "opengl pulseaudio"

IMAGE_INSTALL += "\
  openyard-app \
"

EXTRA_IMAGE_FEATURES += " package-management "

PACKAGECONFIG_append_pn-qtbase = " "
PACKAGECONFIG_append_pn-qtmultimedia = " "

# Config packages: can overwrite files in other packages
# Make sure a value is always set
IMAGE_CONFIG ??= " "

ROOTFS_POSTPROCESS_COMMAND =+ " install_config_packages; "

RDEPENDS_${PN} += "${IMAGE_CONFIG}"
