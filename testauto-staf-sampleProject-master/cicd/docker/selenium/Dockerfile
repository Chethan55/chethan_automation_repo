FROM nexusprod.corp.intranet:4566/devbaseimages/development_base_images/java8:2021Q1
LABEL Description="This is a base image, which provides a selenium environment"

ARG user=jenkins
ARG group=jenkins
ARG uid=1341
ARG gid=1341
USER root
RUN getent group ${gid} || groupadd -g ${gid} ${group}
RUN useradd -c "Jenkins user" -d /home/${user} -u ${uid} -g ${gid} -m ${user}
RUN usermod -a -G root ${user}
ENV INSTALL_DIR=${INSTALL_DIR:-/usr}
ARG MAVEN_VERSION=${MAVEN_VERSION:-3.6.1}
ENV MAVEN_VERSION=${MAVEN_VERSION}
ENV MAVEN_HOME=/usr/apache-maven-${MAVEN_VERSION}
ENV PATH=${PATH}:${MAVEN_HOME}/bin
RUN curl -sL http://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  | gunzip \
  | tar x -C /usr/ \
  && ln -s ${MAVEN_HOME} /usr/maven
ENV PATH=${PATH}:${JAVA_HOME}/bin


RUN wget https://dl.google.com/linux/chrome/rpm/stable/x86_64/google-chrome-stable-94.0.4606.61-1.x86_64.rpm && \
    yum localinstall google-chrome-stable-94.0.4606.61-1.x86_64.rpm -y  && \
    rm -rf google-chrome-stable_current_x86_64.rpm


RUN echo "net.ipv6.conf.all.disable_ipv6 = 1" >> /etc/sysctl.conf && \
    echo "net.ipv6.conf.default.disable_ipv6 = 1" >> /etc/sysctl.conf


RUN usermod -a -G root ${user}
