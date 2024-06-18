FROM gitpod/workspace-full

USER gitpod

# Install netcat
RUN sudo apt-get update && sudo apt-get install -y netcat

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 21.0.2-open && \
    sdk default java 21.0.2-open"